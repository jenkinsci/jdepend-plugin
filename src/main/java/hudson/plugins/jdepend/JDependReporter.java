package hudson.plugins.jdepend;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Locale;
import java.util.ResourceBundle;

import org.apache.maven.reporting.MavenReportException;
import org.codehaus.mojo.jdepend.JDependMojo;
import org.apache.maven.doxia.module.xhtml.XhtmlSinkFactory;
import org.apache.maven.doxia.sink.Sink;


/**
 * A subclass of JDepend Mojo to create a sink outside of the Maven
 * architecture and generate a report.
 * 
 * @author cflewis
 *
 */
public class JDependReporter extends JDependMojo 
{
	protected JDependParser xmlParser;
	
	/**
	 * Create a new report from the parsed JDepend report
	 * @param xmlParser A parsed JDepend report
	 */
	public JDependReporter(JDependParser xmlParser) {
		super();
		this.xmlParser = xmlParser;
	}
	
	/**
	 * The old generateReport from the Codehaus JDepend Mojo,
	 * no longer used.
	 * 
	 * @deprecated Use getReport() instead
	 * @see getReport()
	 */
	public void generateReport(Locale locale) throws MavenReportException {
		throw new MavenReportException("Use getReport() instead!");
	}
	
	/**
	 * Get the HTML report.
	 * @return HTML report
	 * @throws MavenReportException when something bad happens
	 */
	public String getReport() throws MavenReportException {
		return getReport(Locale.ENGLISH);
	}
	
	/**
	 * Get the HTML report.
	 * @param locale
	 * @return
	 * @throws MavenReportException
	 */
	public String getReport(Locale locale) throws MavenReportException {
		XhtmlSinkFactory sinkFactory = new XhtmlSinkFactory();
        Sink sink;
        JDependReportGenerator report = new JDependReportGenerator();
        ByteArrayOutputStream htmlStream = new ByteArrayOutputStream();
        
        try
        {     
        	sink = (Sink)sinkFactory.createSink(htmlStream);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
        	throw new MavenReportException("Couldn't find sink: " + e, e);
        }
        
        try
        {
            report.doGenerateReport(getBundle(), sink, xmlParser);
        }
        catch (Exception e)
        {
        	e.printStackTrace();
            throw new MavenReportException("Failed to generate JDepend report:" + e.getMessage(), e);
        }
          
        try {
            return htmlStream.toString(Charset.defaultCharset().name());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    protected ResourceBundle getBundle() {
        return ResourceBundle.getBundle("org.codehaus.mojo.jdepend.jdepend-report");
    }
}
