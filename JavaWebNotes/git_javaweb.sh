#!/bin/bash

# 步骤1：将某个目录添加到Git暂存区
git add ./*

# 步骤2：提示用户输入提交说明
read -p "请输入提交说明: " commit_message

# 步骤3：提交更改，包括用户输入的提交消息
git commit -m "$commit_message"

# 步骤4：将更改推送到远程仓库的master分支
git push origin master
