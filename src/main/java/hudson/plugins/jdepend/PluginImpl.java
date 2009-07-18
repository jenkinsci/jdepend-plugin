package hudson.plugins.jdepend;

import hudson.Extension;
import hudson.Plugin;
import hudson.tasks.BuildStep;
import hudson.tasks.Publisher;

/**
 * Entry point of the JDepend plugin
 * 
 * @author Chris Lewis
 */

@Extension
public class PluginImpl extends Plugin 
{
	public PluginImpl()
	{
		super();
	}
}
