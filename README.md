# JDepend

The JDepend Plugin is a plugin to generate JDepend reports for builds.

## Quickstart

1. Download the JDepend plugin from the Update Center.
2. Enable for a project by checking "Report JDepend" under the "Post-build actions" of your project.
3. Run a build.
4. View the build page once it has completed, and you should see a "JDepend" entry on the left sidebar.

## Notes

The JDepend plugin does not currently report the health of a project,
as the sheer number of metrics available in a JDepend report makes it very difficult to find any sort of reasonable estimate of what makes a healthy project.
This is one of the times when human intuition might be best!

## Bug reporting

Please direct all bugs to the [issue tracker](https://issues.jenkins.io/), making sure to mention "JDepend" somewhere in the heading or body.
Bugs will continue to be looked at and fixed (features will not).

## Feature requests

Please direct all feature requests to the [issue tracker](https://issues.jenkins.io/), making sure to mention "JDepend" somewhere in the heading or body.
Please note that active development on this plugin has ceased for the time being (the original itch has been scratched),
so if you have new features, it will be quicker to try having a go yourself and make a commit to the Git repository.
The code should be fairly good.
