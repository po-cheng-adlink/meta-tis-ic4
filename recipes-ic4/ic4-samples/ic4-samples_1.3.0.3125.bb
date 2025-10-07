SUMMARY = "The Imaging Source IC4 examples"
DESCRIPTION = "Fetches https://github.com/TheImagingSource/ic4-examples and installs it into the default user's home directory."
HOMEPAGE = "https://github.com/TheImagingSource/ic4-examples"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76f9b634bc5499ed996452ef6f4456dc"

SRCREV = "672a9295323a3416b3abe7a7070f77743c4f4fbe"
SRC_URI = "git://github.com/TheImagingSource/ic4-examples.git;protocol=https;branch=master \
           file://0001-save-jpeg-file-fix-RuntimeError-Library.init-was-not.patch \
          "

RDEPENDS:${PN} = "python3 python3-pyside6"
S = "${WORKDIR}/git"

do_install() {
    install -d "${D}/opt/${PN}"
    # Recursively copy files and directories, preserving mode and timestamps but not ownership
    cp -R --no-preserve=ownership ${S}/* ${D}/opt/${PN}/
}

FILES:${PN} = "/opt/${PN}"
