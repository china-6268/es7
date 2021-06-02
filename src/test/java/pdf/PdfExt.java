package pdf;

import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.pdf.PDFParser;
import org.apache.tika.sax.BodyContentHandler;

import java.io.File;
import java.io.FileInputStream;

/**
 * @author Jasper Liuzengyu 刘增玉
 * @version v1.0.0
 * @description
 * @date 2021/5/26
 * @since v1.0
 */
public class PdfExt {
    public static void main(String[] args) throws Exception {
        //Tika默认是10*1024*1024，这里防止文件过大导致Tika报错
        BodyContentHandler handler = new BodyContentHandler(100 * 1024 * 1024);

        Metadata metadata = new Metadata();
        FileInputStream inputstream = new FileInputStream(new File("/opt/21.05/code/pdf_ext/知网样本文件_all.pdf"));
        ParseContext pcontext = new ParseContext();
        // 解析PDF文档时应由超类AbstractParser的派生类PDFParser实现
        PDFParser pdfparser = new PDFParser();
        pdfparser.parse(inputstream, handler, metadata, pcontext);
        // 获取PDF文档的内容
        System.err.println("PDF文档内容:" + handler.toString());
        // 获取PDF文档的元数据
        System.out.println("PDF文档元数据:");
        String[] metadataNames = metadata.names();
        for (String name : metadataNames) {
            System.out.println(name + " : " + metadata.get(name));
        }
    }
}
