#! /bin/sh

#daytime=$(date +%Y-%m-%d)
stime=$(date +%Y-%m-%d\ %H:%M:%S)
# 14-北京任子行
platformStatus=(14)
for p in ${platformStatus[@]}
do
echo "$stime platformId=$p route-status" >> route-status-send.log
curl -s -XPOST -d "platformId=$p&products=router,ap,probe&factoryIds=1001&status=true&eventTopic=router-status" http://localhost:30080/manage/routerTask/send.json >> route-status-send.log
echo "" >> route-status-send.log
done

#curl -XPOST -d 'platformId=388&products=router&factoryIds=1001&status=true&eventTopic=router-status'  http://localhost:30080/manage/routerTask/send.json
