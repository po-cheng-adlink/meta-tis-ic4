include ic4-gentl-driver.inc

RDEPENDS:${PN} = "util-linux-libuuid libcamera"

INSANE_SKIP:${PN} += "file-rdeps"
