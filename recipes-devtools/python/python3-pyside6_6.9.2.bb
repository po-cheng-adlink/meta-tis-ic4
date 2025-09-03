SUMMARY = "Python bindings for the Qt cross-platform application and UI framework"
HOMEPAGE = "https://pyside.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

#https://files.pythonhosted.org/packages/94/2d/715db9da437b4632d06e2c4718aee9937760b84cf36c23d5441989e581b0/pyside6-6.9.2-cp39-abi3-manylinux_2_39_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/94/2d/715db9da437b4632d06e2c4718aee9937760b84cf36c23d5441989e581b0/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "a78fad16241a1f2ed0fa0098cf3d621f591fc75b4badb7f3fa3959c9d861c806"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "already-stripped file-rdeps"

