SUMMARY = "Python/C++ bindings helper module"
HOMEPAGE = "https://pyside.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

#https://files.pythonhosted.org/packages/52/c4/09e902f5612a509cef2c8712c516e4fe44f3a1ae9fcd8921baddb5e6bae4/shiboken6-6.9.2-cp39-abi3-manylinux_2_39_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/52/c4/09e902f5612a509cef2c8712c516e4fe44f3a1ae9fcd8921baddb5e6bae4/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "a5f5985938f5acb604c23536a0ff2efb3cccb77d23da91fbaff8fd8ded3dceb4"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "already-stripped file-rdeps"

