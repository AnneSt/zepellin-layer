LOCAL_CONF="conf/local.conf"
DOWNLOADS_DIR="/opt/packagepool"
SSTATE_CACHE_DIR="rpi/sstache"
BUILD_DIR="rpi/build"

export TEMPLATECONF="../rpi/meta-zepellin/conf"
. poky-sumo/oe-init-build-env

sed -i "/^DL_DIR/d" $LOCAL_CONF
echo "DL_DIR = \"${DOWNLOADS_DIR}\"" >> $LOCAL_CONF
sed -i "/^SSTATE_DIR/d" $LOCAL_CONF
echo "SSTATE_DIR = \"${SSTATE_CACHE_DIR}\"" >> $LOCAL_CONF
sed -i "/^IMAGE_BUILD_NAME/d" $LOCAL_CONF
echo "IMAGE_BUILD_NAME = \"${BUILD_DIR}\"" >> $LOCAL_CONF
