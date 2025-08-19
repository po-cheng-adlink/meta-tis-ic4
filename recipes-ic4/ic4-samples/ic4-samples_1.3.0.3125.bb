SUMMARY = "ic4-samples"
DESCRIPTION = "Samples for ic4 USB camera"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76f9b634bc5499ed996452ef6f4456dc"

SRC_REV = "672a9295323a3416b3abe7a7070f77743c4f4fbe"
SRC_URI = "git://github.com/TheImagingSource/ic4-examples.git;protocol=https;branch=master \
           file://0001-save-jpeg-file-fix-RuntimeError-Library.init-was-not.patch \
          "

RDEPENDS += "python3 python3-pyside6"

do_install() {
    install -d "${D}/opt"
    # Recursively copy files and directories, preserving mode and timestamps but not ownership
    cp -R --no-preserve=ownership ${WORKDIR}/git/* ${D}/opt
}

FILES:${PN} = "/opt"
