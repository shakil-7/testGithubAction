port="9999"

mvn test

pid=$(lsof -i :$port | grep "java" | awk '{print $2}' | grep '^[0-9]\+$')
echo $pid

for process in $pid; do
	kill -9 $process
done
