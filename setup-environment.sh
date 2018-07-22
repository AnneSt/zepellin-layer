LOCAL_CONF="conf/local.conf"
DOWNLOADS_DIR="/opt/packagepool"

export TEMPLATECONF="../rpi/meta-zepellin/conf"
export BUILDDIR="../rpi/build"
. poky-sumo/oe-init-build-env 

sed -i "/^DL_DIR/d" $LOCAL_CONF
echo "DL_DIR = \"${DOWNLOADS_DIR}\"" >> $LOCAL_CONF
