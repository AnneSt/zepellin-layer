DESCRIPTION = "ROS message for zeppelin."
SECTION = "devel"
LICENSE = "CLOSED"
#LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "git://blackcube.fritz.box/opt/git/zeppelin.git;user=gitserver;protocol=ssh \
	   file://magic8ball.sh"
SRCREV = "${AUTOREV}"

S="${WORKDIR}/git/src"

DEPENDS = "roscpp rospy genmsg"

inherit catkin

ROS_SPN = "magic8ball"

do_install_append() {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/magic8ball.sh ${D}${sysconfdir}/init.d/magic8ball.sh

	install -d ${D}${sysconfdir}/rc6.d
	install -d ${D}${sysconfdir}/rc1.d
	cd ${D}${sysconfdir}/init.d/
	ln -s magic8ball.sh ../rc6.d/S99magic8ball
	ln -s magic8ball.sh ../rc1.d/K01magic8ball
}


