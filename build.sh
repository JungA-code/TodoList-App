#### TODO APP Build Script ####
## You can get help by entering 'help' in the argument.
# If you only want to see the build results, type the following command.
# ./build.sh build
#
# If you want to run the previous image, enter the command run.
# ./build.sh run
#
# If the argument is not specified, the source file is built and executed.
########################

JAR_OUTPUT_PATH='app/build/libs/'

build_function() {
    ./gradlew build
}

excute_funtion() {
    chmod 777 $JAR_OUTPUT_PATH/app.jar
    cp -r $JAR_OUTPUT_PATH/app.jar OUTPUT/
    echo
    java -jar OUTPUT/app.jar
}

# Invoke a function
if [ "$1" = "build" ]; then {
    echo ============ build ===============
    build_function
    echo =================================
}
elif [ "$1" = "run" ]; then {
    echo ============ excute ===============
    excute_funtion
    echo ===================================
}
elif [ "$1" = "help" ]; then {
    echo 'build option [build, run]'
}
else
    build_function
    excute_funtion
fi