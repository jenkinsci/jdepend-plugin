/**
 * 
 */
package hudson.plugins.jdepend;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.codehaus.mojo.jdepend.JDependXMLReportParser;
import org.codehaus.mojo.jdepend.objects.JDPackage;
import org.xml.sax.SAXException;

/**
 * @author cflewis
 *
 */
public class JDependParser extends JDependXMLReportParser {

	/**
	 * An extension from the Codehaus JDependXMLReportParser
	 * to allow custom methods to be added.
	 * 
	 * @param xmlFile
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public JDependParser(File xmlFile) throws ParserConfigurationException,
			SAXException, IOException {
		super(xmlFile);
	}
	
    /**
     * Counts the total number of classes in all packages in the parser.
     * 
     * This would work better if it cached the result.
     * 
     * @param packages
     * @return The total number of classes parsed.
     */
	protected String getTotalClasses()
    {
    	int totalClasses = 0;
    	
    	for (Iterator<?> it = packages.iterator(); it.hasNext();) {
    		JDPackage jdp = (JDPackage)it.next();
    		totalClasses = totalClasses + Integer.parseInt(jdp.getStats().getTotalClasses());
    	}
    	
    	return Integer.toString(totalClasses);
    }

	/**
	 * Returns the cycles from the parser object, required for the
	 * Codehaus HTML outputter to work.
	 * 
	 * @return cycles (not really sure what this even is!)
	 */
	public List getCycles() {
		return cycles;
	}
}
