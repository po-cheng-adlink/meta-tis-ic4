SUMMARY = "IC4 imaging camera package group"
DESCRIPTION = "Package group for IC4 imaging camera components including drivers and GStreamer support"

LICENSE = "MIT"

inherit packagegroup

RDEPENDS:${PN} = "\
    ic4 \
    ic4-plugins \
    ic4-gentl-driver-usb3vision \
    ic4-gentl-driver-gigevision \
    ic4-gentl-driver-libcamera \
"

# Optional: Create sub-packages for different configurations
PACKAGES =+ "\
    ${PN}-gstreamer \
"

RDEPENDS:${PN}-gstreamer = "\
    packagegroup-ic4 \
"
