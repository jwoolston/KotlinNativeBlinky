rm -f program.o

mkdir -p $DIR/build/kotlin

konanc $DIR/../src/stm32f4Main/kotlin/main.kt \
        -target zephyr_$BOARD \
        -r $DIR/c_interop/platforms/build \
        -l $BOARD \
        -opt -g -o $DIR/build/kotlin/program || exit 1