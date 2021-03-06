# KotlinNativeBlinky

Basic example showing how Kotlin Native can be used with Zephyr RTOS on an STM32F4 Discovery board.

## How-To
1. Linux or OSX (untested) environment.
2. This project assumes that you have installed the Zephyr SDK and cloned the Zephyr GIT repository. Instructions can be found on the [Zephyr Website](https://docs.zephyrproject.org/latest/getting_started/installation_linux.html). Note that it is not necessary for this project to export the environment variables. 
3. Update the paths in `local.properties` as appropriate for your install and repository clone.
4. Run the `fullBuild` task
5. With you board board powered up and connected to your computer, execute the `flashBoard` task to program.

*NOTE: Due to the beta status of kotlin-native, this may break in the future (I will try and keep it current) and the task execution does take a while as there have been no substantial optimization efforts yet for the kotlin-native tools.*
