package data;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @name: LicenseDataBuild
 * @author: mubai.
 * @date: 2021/10/8.
 * @version: 1.0
 * @description: license造数工具类
 */
public class LicenseDataBuild {

    private static final String TEMPLATE_PATH = "D:\\ccbc\\data\\master_device_template.sql";

    private static final String CENTER_TEMPLATE_PATH = "D:\\ccbc\\data\\center_device_template.sql";

    private static final String OUTPUT_PATH = "D:\\ccbc\\data\\result";

    private static final String OUTPUT_FILE_NAME = "MASTER_DEVICE_TEST.sql";

    private static final String CENTER_OUTPUT_FILE_NAME = "CENTER_DEVICE_TEST.sql";


    public static void main(String[] args) throws IOException {
        writeLicenseTemplate(1, 10);
    }

    /**
     * 造数逻辑：
     * SN_PARAM : SN2021100+NUMBER   CHAIN_PARAM = NUMBER  DEVICE_LINK_PARAM=(NUMBER+(1~10)-1) * 10000
     * 分库中的csDevice表跟随上面的DEVICE_LINCK_PARAM规则
     * 例子：
     * NUMBER = 1
     * SN_PARAM = SN20211001    CHAIN_PARAM = 1   DEVICE_LINK_PARAM = 10000~100000
     * 每个网关号下默认挂10个设备
     * @param beginNumber 开始网关号
     * @param endNumber 结束网关号
     */
    public static void writeLicenseTemplate(int beginNumber, int endNumber) throws IOException {
        if (beginNumber < 1 || endNumber < 1 || beginNumber > endNumber) {
            throw new RuntimeException("入参不规范");
        }
        //读取模板文件
        FileReader fr = new FileReader(TEMPLATE_PATH);
        FileReader centerFr = new FileReader(CENTER_TEMPLATE_PATH);
        StringBuilder templateBuilder = new StringBuilder();
        StringBuilder centerTemplateBuilder = new StringBuilder();
        int len = 0;
        while ((len = fr.read()) != -1) {
            templateBuilder.append((char) len);
        }
        int centerLen = 0;
        while ((centerLen = centerFr.read()) != -1) {
            centerTemplateBuilder.append((char) centerLen);
        }
        FileWriter fw = new FileWriter(OUTPUT_PATH + File.separator + OUTPUT_FILE_NAME);
        FileWriter fw2 = new FileWriter(OUTPUT_PATH + File.separator + CENTER_OUTPUT_FILE_NAME);
        for (int i = beginNumber; i <= endNumber; i++) {
            for (int j = 1; j <= 10; j++) {
                String templateStr = templateBuilder.toString();
                String str1 = templateStr.replace("CHAIN_PARAM", String.valueOf(i));
                String str2 = str1.replace("DEVICE_LINK_PARAM", String.valueOf(((i - 1) * 10 + j) * 10000));
                String str33 = str2.replace("IMEI_NUMBER", String.valueOf(j));
                String str = str33.replace("ID_NUMBER", String.valueOf(j));
                fw.write(str);
                System.out.println("device data number:" + (i - 1) * 10 + j);
                fw.flush();
                String centerTemplateStr = centerTemplateBuilder.toString();
                String str3 = centerTemplateStr.replace("CHAIN_PARAM", String.valueOf(i));
                String str4 = str3.replace("DEVICE_LINK_PARAM", String.valueOf(((i - 1) * 10 + j) * 10000));
                String str5 = str4.replace("IMEI_NUMBER", String.valueOf(j));
                String str6 = str5.replace("ID_NUMBER", String.valueOf(j));
                fw2.write(str6);
                System.out.println("center device data number:" + (i - 1) * 10 + j);
                fw.flush();
            }
        }
        fw.close();
        fw2.close();
        fr.close();
    }

}
