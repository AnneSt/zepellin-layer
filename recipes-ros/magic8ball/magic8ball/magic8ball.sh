# !/bin/bash
LOG_FILE=/var/log/log_start_roslaunch.log
echo "" >> ${LOG_FILE}
echo "" >> ${LOG_FILE}
echo "--------------" >> ${LOG_FILE}
echo "Starting Ros" >> ${LOG_FILE}
echo $(date) >> ${LOG_FILE}
echo "--------------" >> ${LOG_FILE}
echo "" >> ${LOG_FILE}
echo "Logs:" >> ${LOG_FILE}

set -e
{
	source /etc/default/roscore
	export ROS_ROOT=/opt/ros/indigo
	export PATH=$PATH:/opt/ros/indigo/bin
	export LD_LIBRARY_PATH=/opt/ros/indigo/lib
	export PYTHONPATH=/opt/ros/indigo/lib/python2.7/site-packages
	export ROS_MASTER_URI=http://raspberrypi3:11311
	export CMAKE_PREFIX_PATH=/opt/ros/indigo
	touch /opt/ros/indigo/.catkin

	sleep 8
} &>> ${LOG_FILE}

set -v
{
	roslaunch magic8ball magic8ball.launch
} &>> ${LOG_FILE}
