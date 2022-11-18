/**
 * 
 */
package hudson.plugins.jdepend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.Run;
import jenkins.model.RunAction2;
import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import edu.umd.cs.findbugs.annotations.CheckForNull;

/**
 * A build action to generate JDepend HTML reports
 * @author cflewis
 *
 */
public class JDependBuildAction implements RunAction2
{
	private String htmlReport;
	private transient Run<?,?> owner;

	public JDependBuildAction(JDependParser jDependParser) {
		this(null, jDependParser);
	}

	/**
	 * @deprecated Use {@link #JDependBuildAction(JDependParser)}
	 */
	@Deprecated
	public JDependBuildAction(@CheckForNull AbstractBuild<?, ?> build, JDependParser jDependParser)
	{
		super();
		this.owner = build;
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

	/**
	 * Gets current parser.
	 * Not persisted over the restart.
	 * @return Always {@code null}
	 */
	@Deprecated
	@CheckForNull
	public JDependParser getJDependParser() {
		return null;
	}

	@Override
	public void onAttached(Run<?, ?> r) {
		this.owner = r;
	}

	@Override
	public void onLoad(Run<?, ?> r) {
		this.owner = r;
	}

	@Restricted(NoExternalUse.class)
	public Run<?, ?> getOwner() {
		return owner;
	}
}
