# Changelog

### Version 1.3.0 (Feb 22, 2018)

- [JENKINS-49586](https://issues.jenkins-ci.org/browse/JENKINS-49586) - Make the plugin compatible with Jenkins 2.102+
- More info: [Plugins affected by fix for JEP-200](https://wiki.jenkins.io/display/JENKINS/Plugins+affected+by+fix+for+JEP-200)
- [Commit](https://github.com/jenkinsci/jdepend-plugin/commit/0c8fbfa25f1dac94b1df242578b12da2cd4ac7ec)
- Create JDepend temporary directory on controller (reverts change in 1.2.4)

### Version 1.2.4 (Nov 03, 2014)

- [Commit](https://github.com/jenkinsci/jdepend-plugin/commit/967b803b52c50d900408de10ad8535f4716af821) - Create JDepend temporary directory on agent instead of the controller

### Version 1.2.3 (Feb 14, 2011)

- Remove unused code.

### Version 1.2.2 (Sep 17, 2009)

- Fixed config file growth. ([JENKINS-4494](https://issues.jenkins-ci.org/browse/JENKINS-4494))

### Version 1.2.1 (Aug 29, 2009)

- Added relative path to workspace as a possible configuration. No compatibility for Ant-style FileSets though, there should only be one JDepend report.

### Version 1.2

- Use existing JDepend XML file. ([JENKINS-4083](https://issues.jenkins-ci.org/browse/JENKINS-4083))

Version 1.0 was developed by Chris Lewis (lewisham).
Development of version 1.0 of this plugin was made possible by the National Science Foundation and released under the BSD license from the University of California, Santa Cruz.
If you like it, remember to keep voting for the public funding of scientific and educational facilities!
