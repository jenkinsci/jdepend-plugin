/**
 * 
 */
package com.cflewis.hudson.jdepend;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import hudson.model.AbstractBuild;
import hudson.model.Action;
import hudson.model.Build;

/**
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
    	
    	try
    	{
    		htmlReport = r.getReport();
    	}
    	catch (Exception e)
    	{
    		htmlReport = "Report generation failed: " + e;
    	}
	}
	
	/* (non-Javadoc)
	 * @see hudson.model.Action#getDisplayName()
	 */
	public String getDisplayName() 
	{
		// TODO Auto-generated method stub
		return "JDepend";
	}

	/* (non-Javadoc)
	 * @see hudson.model.Action#getIconFileName()
	 */
	public String getIconFileName() 
	{
		// TODO Auto-generated method stub
		return "graph.gif";
	}

	/* (non-Javadoc)
	 * @see hudson.model.Action#getUrlName()
	 */
	public String getUrlName() 
	{
		// TODO Auto-generated method stub
		return "jdepend";
	}

	public String getJDependHtml()
	{
		Pattern trimTop = Pattern.compile("^.*<body>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		Pattern trimBottom = Pattern.compile("</body>.*</html>", Pattern.MULTILINE | Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
		
		Matcher topMatcher = trimTop.matcher(htmlReport);
		htmlReport = topMatcher.replaceAll("");
		
		Matcher bottomMatcher = trimBottom.matcher(htmlReport);
		htmlReport = bottomMatcher.replaceAll("");

		return htmlReport;
	}
}
