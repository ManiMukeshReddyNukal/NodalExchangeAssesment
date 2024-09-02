#!/usr/bin/env bash
# wait-for-it.sh

set -e

host="$1"
shift
cmd="$@"

until nc -z "$host" 8082; do
  echo "Waiting for $host:8082..."
  sleep 5
done

>&2 echo "$host:8082 is up - executing command"
exec $cmd
