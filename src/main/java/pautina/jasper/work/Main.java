package pautina.jasper.work;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlWriter;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlWriter;

public class Main {
    public static void main(String[] args) throws JRException {

        String sourceFile = "";
        String destinationFile = "";

        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("-if")) {
                sourceFile = args[++i];
                System.out.println("source: " + sourceFile);
            } else if (args[i].equals("-of")) {
                destinationFile = args[++i];
                System.out.println("dest: " + destinationFile);
            } else if (args[i].equals("--decompile") || args[i].equals("-d")) {
                jasperDecompile(sourceFile, destinationFile);
            } else if (args[i].equals("--compile") || args[i].equals("-c")) {
                jasperCompile(sourceFile, destinationFile);
            }
        }

    }

    public static void jasperDecompile(String sourceFile, String destinationFile) throws JRException {
        JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(sourceFile);
        JRXmlWriter.writeReport(report, destinationFile, "UTF-8");

        System.out.println(sourceFile + "decompiled!");
    }

    public static void jasperCompile(String sourceFile, String destinationFile) throws JRException {
        JasperCompileManager.compileReportToFile(sourceFile, destinationFile);

        System.out.println(sourceFile + "compiled!");
    }
}