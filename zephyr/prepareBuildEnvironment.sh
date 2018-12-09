#!/usr/bin/env bash
BOARD=$1
export ZEPHYR_SDK_INSTALL_DIR=$2
export ZEPHYR_BASE=$3
export KONAN_DEPS="$HOME/.konan/dependencies"
SCRIPT=$4

DIR=$(cd "$(dirname "${BASH_SOURCE[0]}" )" && pwd )

if [ -z "$KONAN_HOME" ]; then
    PATH="$DIR/../../dist/bin:$DIR/../../bin:$PATH"
else
    PATH="$KONAN_HOME/bin:$PATH"
fi

if [ x$TARGET == x ]; then
case "$OSTYPE" in
  darwin*)  TOOLCHAIN=gcc-arm-none-eabi-7-2017-q4-major-mac ;;
  linux*)   TOOLCHAIN=gcc-arm-none-eabi-7-2017-q4-major-linux ;;
  *)        echo "unknown: $OSTYPE" && exit 1;;
esac
fi

GNU_ARM="$KONAN_DEPS/$TOOLCHAIN"

export ZEPHYR_TOOLCHAIN_VARIANT=gnuarmemb
export GNUARMEMB_TOOLCHAIN_PATH=$GNU_ARM

. ${SCRIPT}