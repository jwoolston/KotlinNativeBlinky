rm -rf $DIR/build || exit 1
mkdir -p $DIR/build && cd $DIR/build

[ -f CMakeCache.txt ] || cmake -DCMAKE_VERBOSE_MAKEFILE=ON -GNinja -DBOARD=$BOARD .. || exit 1

# We need generated headers to be consumed by `cinterop`,
# so we preconfigure the project with `ninja zephyr`.
ninja zephyr