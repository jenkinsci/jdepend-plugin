/**
 * 
 */
package hudson.plugins.jdepend;

import hudson.model.AbstractProject;
import hudson.model.Action;

/**
 * The project actions for JDepend. Currently this does nothing.
 * @author cflewis
 *
 */
public final class JDependProjectAction implements Action 
{
	public final AbstractProject<?,?> project;
	
	public JDependProjectAction(AbstractProject<?, ?> project) {
		this.project = project;
	}
	
	public String getIconFileName() {
		return null;
		//return "graph.gif";
	}
	
	public String getDisplayName() {
		return null;
		//return "JDepend";
	}
	
	public String getUrlName() {
		return null;
		//return "jdepend";
	}
	
	public String getJDependHtml() {
		return "This is the JDepend HTML, which may eventually show trends.";
	}
}
