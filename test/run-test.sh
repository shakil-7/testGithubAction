port="9999"

mvn test| tail -n 20

pid=$(lsof -i :$port | grep "java" | awk '{print $2}' | grep '^[0-9]\+$')
echo $pid

for process in $pid; do
	kill -9 $process
done
