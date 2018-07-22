LOCAL_CONF="conf/local.conf"
DOWNLOADS_DIR="/opt/packagepool"
BUILD_NAME="rpi/build"
SSTATE_CACHE_DIR="rpi/sstache"

export TEMPLATECONF="rpi/meta-zepellin/conf"
. poky-sumo/oe-init-build-env
