#!/bin/bash

# Sys Report Generation

TITLE="System Information Report for $HOSTNAME"
CURRENT_TIME=$(date +"%x %r %Z")
TIME_STAMP="Generated $CURRENT_TIME, by $USER"

report_uptime(){
	echo "uptime report generated"
	return
}

report_disk_space(){
	echo "disk space report generated"
	return
}

report_home_space(){
	echo "home space report generated"
	return
}

cat << _EOF_
TITLE: $TITLE


$TIME_STAMP

$(report_uptime)
