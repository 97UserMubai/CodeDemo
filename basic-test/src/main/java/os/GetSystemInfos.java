package os;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @name: GetSystemInfos
 * @author: Mubai.Wang
 * @date: 2023/2/6
 * @version: 1.0
 * @description:
 */
@Slf4j
public class GetSystemInfos {

    private static final String GET_WINDOWS_MAIN_BROD_CMD = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
            + "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_BaseBoard\") \n"
            + "For Each objItem in colItems \n" + "    Wscript.Echo objItem.SerialNumber \n"
            + "    exit for  ' do the first cpu only! \n" + "Next \n";
    private static final String GET_WINDOWS_CPU_ID_CMD = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
            + "Set colItems = objWMIService.ExecQuery _ \n" + "   (\"Select * from Win32_Processor\") \n"
            + "For Each objItem in colItems \n" + "    Wscript.Echo objItem.ProcessorId \n"
            + "    exit for  ' do the first cpu only! \n" + "Next \n";
    private static final String FILE_PATH = "E:\\文档\\个人\\0207.txt";

    /**
     * 获取机器码demo
     */
    public static void main(String[] args) throws IOException {
        /*
         * 读取注册表的数据，windows环境中通过ddl访问注册表信息比较复杂，所以暂时不支持机器码的存储
         * 在Linux环境中通过判断当前环境的/etc/security/machine-code/pi_code文件，判断内容是否存在，存在则校验通过之后返回并且覆盖文件
         * */
        byte[] bytes = new byte[1028];
        int readCont = 0;
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream(FILE_PATH)) {
            while ((readCont = fileInputStream.read(bytes)) != -1) {
                stringBuilder.append(new String(bytes, 0, readCont));
            }
        }
        String result = stringBuilder.toString();
        System.out.println("从文件中获取得到的机器码：" + result);
        if (result.length() == 32) {
            System.out.println("机器码符合条件，直接返回:" + result);
            return;
        }
        String systemName = System.getProperty("os.name");
        System.out.println(systemName);
        String mainBrodId;
        try {
            mainBrodId = getResultFromWindows(GET_WINDOWS_MAIN_BROD_CMD);
        } catch (Exception e) {
            log.warn("获取主板信息失败", e);
            mainBrodId = "/FS1GFD2/CN7016365402TV/";
        }
        System.out.println("主板号：" + mainBrodId);

        String cpuId;
        try {
            cpuId = getResultFromWindows(GET_WINDOWS_CPU_ID_CMD);
        } catch (Exception e) {
            log.warn("获取CPUID信息失败", e);
            cpuId = "BFEBFBFF000306C3";
        }
        System.out.println("cpuId:" + cpuId);
        //生成机器码，只是简单地将cpuId和主板号进行拼接，然后生成一个MD5信息
        String md5Msg = getMD5(cpuId + mainBrodId);
        System.out.println("32位MD5消息为:" + md5Msg);
        //输出到文件中
        try (OutputStream os = new FileOutputStream(new File(FILE_PATH))) {
            os.write(md5Msg.getBytes(), 0, md5Msg.length());
        }
        System.out.println("输出文件成功");
    }

    /**
     * 获取MD5信息
     *
     * @param source source
     * @return String
     */
    public static String getMD5(String source) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes());
            byte[] bytes = md.digest();
            int i;
            StringBuilder buf = new StringBuilder("");
            for (byte aByte : bytes) {
                i = aByte;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            log.info("获取MD5信息失败", e);
        }
        return result;
    }

    /**
     * 从windows中执行命令并得到解析信息
     *
     * @return String
     */
    public static String getResultFromWindows(String cmd) throws IOException {
        StringBuilder result = new StringBuilder();
        File file = File.createTempFile("temp", ".vbs");
        file.deleteOnExit();
        FileWriter fw = new FileWriter(file);
        fw.write(cmd);
        fw.close();
        Process p = Runtime.getRuntime().exec("cscript //NoLogo " + file.getPath());

        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = input.readLine()) != null) {
            result.append(line);
        }
        input.close();
        return result.toString();
    }
}
