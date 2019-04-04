SUMMARY = "A console development image with some C/C++ dev tools and ROS"
LICENSE = "MIT"

IMAGE_LINGUAS = "en-us"

inherit image

DEPENDS += "bcm2835-bootfiles"

ROS_OS = " \
     roslaunch \
     rostopic \
     magic8ball \
"

CORE_OS = " \
    kernel-modules \
    openssh openssh-keygen \
    dhcp-client \
    packagegroup-core-boot \
    userland \
"

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    g++ \
    g++-symlinks \
    gcc \
    gcc-symlinks \
    gdb \
    gdbserver \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python3-modules \
"

DEBUG = " \
    gdbserver \
"

EXTRA_TOOLS_INSTALL = " \
    i2c-tools \
    spitools \
    iproute2 \
    iptables \
    netcat \
    procps \
    sysfsutils \
    tcpdump \
    ntp \
"

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware \
    wireless-tools \
    wpa-supplicant \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${ROS_OS} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
 "

TOOLCHAIN_HOST_TASK += "nativesdk-cmake nativesdk-catkin"

export IMAGE_BASENAME = "base-image"

