package hudson.plugins.jdepend;

import hudson.Extension;
import hudson.Plugin;
import hudson.tasks.BuildStep;
import hudson.tasks.Publisher;

/**
 * Entry point of a plugin.
 *
 * <p>
 * There must be one {@link Plugin} class in each plugin.
 * See javadoc of {@link Plugin} for more about what can be done on this class.
 *
 * @author Kohsuke Kawaguchi
 */

@Extension
public class PluginImpl extends Plugin 
{
	public PluginImpl()
	{
		super();
	}
}
