package elasticsearch;

import com.alibaba.fastjson.JSON;
import com.code.OrderApplication;
import com.code.entity.es.Hero;
import org.elasticsearch.action.bulk.BulkItemResponse;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.reindex.BulkByScrollResponse;
import org.elasticsearch.index.reindex.DeleteByQueryRequest;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @name: ElasticsearchTest
 * @author: mubai.
 * @date: 2022/7/26
 * @version: 1.0
 * @description: 进行elasticsearch的简单测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = OrderApplication.class)
@AutoConfigureMockMvc
public class ElasticsearchTest {
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Autowired
    @Qualifier(value = "restHighLevelClient")
    private RestHighLevelClient client;

    /**
     * 测试前初始化
     */
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    /**
     * 创建es索引
     */
    @Test
    public void testCreateIndex() throws IOException {
        IndexRequest request = new IndexRequest("hero");
        request.id("1");
        Map<String, String> map = new HashMap<>();
        map.put("id", "1");
        map.put("name", "曹操");
        map.put("country", "魏");
        map.put("birthday", "公元155年");
        map.put("longevity", "65");
        request.source(map);
        IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
        long version = indexResponse.getVersion();
        System.out.println("version:" + version);
        System.out.println(JSON.toJSONString(indexResponse));
    }


    /**
     * 批量插入
     */
    @Test
    public void bulkRequestTest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new IndexRequest("hero").id("2")
                .source(XContentType.JSON, "id", "2", "name", "刘备", "country", "蜀", "birthday", "公元161年", "longevity", "61"));
        request.add(new IndexRequest("hero").id("3")
                .source(XContentType.JSON, "id", "3", "name", "孙权", "country", "吴", "birthday", "公元182年", "longevity", "61"));
        request.add(new IndexRequest("hero").id("4")
                .source(XContentType.JSON, "id", "4", "name", "诸葛亮", "country", "蜀", "birthday", "公元181年", "longevity", "53"));
        request.add(new IndexRequest("hero").id("5")
                .source(XContentType.JSON, "id", "5", "name", "司马懿", "country", "魏", "birthday", "公元179年", "longevity", "72"));
        request.add(new IndexRequest("hero").id("6")
                .source(XContentType.JSON, "id", "6", "name", "荀彧", "country", "魏", "birthday", "公元163年", "longevity", "49"));
        request.add(new IndexRequest("hero").id("7")
                .source(XContentType.JSON, "id", "7", "name", "关羽", "country", "蜀", "birthday", "公元160年", "longevity", "60"));
        request.add(new IndexRequest("hero").id("8")
                .source(XContentType.JSON, "id", "8", "name", "周瑜", "country", "吴", "birthday", "公元175年", "longevity", "35"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(bulkResponse));
    }

    /**
     * 更新
     */
    @Test
    public void updateTest() throws IOException {
        Map<String, Object> jsonMap = new HashMap<>();
        jsonMap.put("country", "魏");
        UpdateRequest request = new UpdateRequest("hero", "7").doc(jsonMap);
        UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(updateResponse));
    }

    /**
     * save
     */
    @Test
    public void insertOrUpdateOne() {
        Hero hero = new Hero();
        hero.setId(5);
        hero.setName("曹丕");
        hero.setCountry("魏");
        hero.setBirthday("公元187年");
        hero.setLongevity(39);
        IndexRequest request = new IndexRequest("hero");
        request.id(hero.getId().toString());
        request.source(JSON.toJSONString(hero), XContentType.JSON);
        try {
            //这里使用index方法，es会自动判断这值是否存在，存在则更新
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);   //  1
            System.out.println(JSON.toJSONString(indexResponse));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除
     */
    @Test
    public void deleteByIdTest() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("hero");
        deleteRequest.id("1");
        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(deleteResponse));
    }

    /**
     * 根据条件删除
     */
    @Test
    public void deleteByQueryRequestTest() throws IOException {
        DeleteByQueryRequest deleteByQueryRequest = new DeleteByQueryRequest("hero");
        deleteByQueryRequest.setConflicts("proceed");
        deleteByQueryRequest.setQuery(new TermQueryBuilder("country", "吴"));
        BulkByScrollResponse bulkByScrollResponse = client.deleteByQuery(deleteByQueryRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSONString(bulkByScrollResponse));
    }

    /**
     * 复合类型操作
     */
    @Test
    public void bulkDiffRequestTest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.add(new DeleteRequest("hero", "3"));
        request.add(new UpdateRequest("hero", "7").doc(XContentType.JSON, "longevity", "70"));
        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        for (BulkItemResponse item : bulkResponse.getItems()) {
            System.out.println(JSON.toJSONString(item));
        }
    }

    /**
     * 单条件Limit查询
     */
    @Test
    public void selectByUserTest() throws IOException {
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder builder = new SearchSourceBuilder();
        builder.query(new TermQueryBuilder("country", "魏"));
        builder.size(1);
        request.source(builder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        System.out.println(JSON.toJSONString(hits));
    }

    /**
     * 多条件传哈讯+排序+分页
     */
    @Test
    public void boolQueryTest() throws IOException {
        SearchRequest request = new SearchRequest("hero");
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        boolQueryBuilder.must(new TermQueryBuilder("country", "魏"));
//        boolQueryBuilder.must(new RangeQueryBuilder("longevity").gte(50));
        sourceBuilder.query(boolQueryBuilder);
        sourceBuilder.from(0).size(2);
        sourceBuilder.query(boolQueryBuilder);
//        sourceBuilder.sort("longevity", SortOrder.DESC);
        request.source(sourceBuilder);
        SearchResponse response = client.search(request, RequestOptions.DEFAULT);
        SearchHit[] hits = response.getHits().getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
            System.out.println(JSON.toJSONString(JSON.parseObject(hit.getSourceAsString(), Hero.class)));
        }
    }

    @Test
    public void test() {
        String[] str = "5275-7896-11200-2561-4383-5900-994-845-1600-889-1000".split("-");
        int total = 0;
        for (String s : str) {
            total += Integer.parseInt(s);
        }
        System.out.println(total);
    }

}
