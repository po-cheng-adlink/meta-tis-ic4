LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76f9b634bc5499ed996452ef6f4456dc \
                    file://libs/tcam-property/LICENSE;md5=76f9b634bc5499ed996452ef6f4456dc"

SRC_URI = "gitsm://git@gitlab.theimagingsource.com:49107/linux/ic4-gstreamer-src.git;protocol=ssh;branch=master \
           file://0001-Install-tcam-libraries.patch \
           "

PV = "1.0+git"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS = "glib-2.0 ic4 fmt cli11 gstreamer1.0 gstreamer1.0-plugins-base"
RDEPENDS:${PN} = "libgstvideo-1.0"

inherit cmake pkgconfig

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

PACKAGES =+ "${PN}-docs"
FILES:${PN}-docs = "${datadir}/theimagingsource/ic4src"

FILES:${PN} = "${libdir}/gstreamer-1.0/libgstic4src.so \
               ${libdir}/libtcamgststatistics.so \
               ${libdir}/libtcam-property.so \
               ${bindir}/ic4-gst-helper"
