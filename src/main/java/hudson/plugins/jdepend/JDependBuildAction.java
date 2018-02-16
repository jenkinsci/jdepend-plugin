/**
 * 
 */
package hudson.plugins.jdepend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hudson.model.AbstractBuild;
import hudson.model.Action;

/**
 * A build action to generate JDepend HTML reports
 * @author cflewis
 *
 */
public class JDependBuildAction implements Action 
{
	public final AbstractBuild<?, ?> build;
	private final JDependParser jDependParser;
	private String htmlReport;
	
	public JDependBuildAction(AbstractBuild<?, ?> build, JDependParser jDependParser)
	{
		super();
		this.build = build;
		this.jDependParser = jDependParser;
    	JDependReporter r = new JDependReporter(jDependParser);
    	
    	try {
    		htmlReport = r.getReport();
    	}
    	catch (Exception e) {
    		htmlReport = "Report generation failed: " + e;
    	}
	}
	
	/** 
	 * Return the JDepend display name
	 * @see hudson.model.Action#getDisplayName()
	 */
	public String getDisplayName() {
		return "JDepend";
	}

	/** 
	 * Return the JDepend icon path
	 * @see hudson.model.Action#getIconFileName()
	 */
	public String getIconFileName() {
		return "graph.gif";
	}

	/**
	 * Returns the path to the JDepend page
	 * @see hudson.model.Action#getUrlName()
	 */
	public String getUrlName() {
		return "jdepend";
	}

	/**
	 * Get the HTML string of the JDepend report.
	 * This report is HTML tidied, and had the {@code <html><body>} tags
	 * and such cruft removed.
	 * 
	 * @return JDepend HTML report
	 */
	public String getJDependHtml() {
		Pattern trimTop = Pattern.compile("^.*<body>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Pattern trimBottom = Pattern.compile("</body>.*</html>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		
		Matcher topMatcher = trimTop.matcher(htmlReport);
		htmlReport = topMatcher.replaceAll("");
		
		Matcher bottomMatcher = trimBottom.matcher(htmlReport);
		htmlReport = bottomMatcher.replaceAll("");

		return htmlReport;
	}

	public JDependParser getJDependParser() {
		return jDependParser;
	}
}
