FROM centos

RUN yum update -y \
	&& yum install -y \
		java-1.8.0-openjdk-devel \
		maven \
		wget \
		graphviz \
		bzip2 \
	&& cd /usr/local/src \
	&& mkdir <product name> \
	&& cd <product name> \	
	&& wget https://github.com/<user|org name>/<repo name>/archive/master.zip \
	&& jar -fx master.zip \
	&& cd <product name>-master/<base name>.aggregator
	&& mvn package
	&& cd /opt
	&& wget https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-2.1.1-linux-x86_64.tar.bz2
	&& tar xvfj phantomjs-2.1.1-linux-x86_64.tar.bz2
	&& rm phantomjs-2.1.1-linux-x86_64.tar.bz2
	&& wget http://www.nasdanika.org/winstone-0.9.10.jar
	&& java -jar winstone-0.9.10.jar --webroot=... --controlPort=8081
	&& mvn product parent
	&& java -cp winstone-0.9.10.jar winstone.tools.WinstoneControl shutdown
	

# -- JDK
# -- Maven
# -- Git
# -- Graphviz
# -- Phantom JS
# - Pull to /usr/local/src/<app name>
# - Build and put to /usr/local/<app name>
# - Uninstall Maven
# - Cleanup yum and wget and bzip2
# - ENTRYPOINT


EXPOSE 8080