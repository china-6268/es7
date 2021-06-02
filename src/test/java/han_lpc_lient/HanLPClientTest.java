package han_lpc_lient;

import com.hankcs.hanlp.restful.HanLPClient;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/31
 * @since v1.0
 */
@Slf4j
public class HanLPClientTest {

    public static void main(String[] args) throws IOException {
        HanLPClient HanLP = new HanLPClient("https://www.hanlp.com/api", null, "zh", 3);
        log.info(String.valueOf(HanLP.parse("2021年HanLPv2.1为生产环境带来次世代最先进的多语种NLP技术。阿婆主来到北京立方庭参观自然语义科技公司。")));
    }
}