#!/bin/bash

{
    cmake --build ./build
    ./build/Proyecto
} || {
    ./build.sh
    cmake --build ./build
    ./build/Proyecto
}
