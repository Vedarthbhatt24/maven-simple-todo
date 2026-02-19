#!/bin/bash

# Nexus Details
URL="http://192.168.0.32:8081"
REPO="calculator_deploy_proj"
GROUP="com.houari"
ARTIFACT="Calculator"
USER="admin"
PASS="Mitul_Devops@123"

# Get Latest Version
VERSION=$(curl -u $USER:$PASS -s \
"$URL/service/rest/v1/search/assets?repository=$REPO&maven.groupId=$GROUP&maven.artifactId=$ARTIFACT&maven.extension=jar&sort=version&direction=desc" \
| jq -r '.items[0].maven2.version')

echo "Latest Version: $VERSION"

# Download JAR
curl -u $USER:$PASS -L \
"$URL/service/rest/v1/search/assets/download?repository=$REPO&maven.groupId=$GROUP&maven.artifactId=$ARTIFACT&maven.extension=jar&sort=version&direction=desc" \
-o "$ARTIFACT-$VERSION.jar"

echo "Download Completed"
