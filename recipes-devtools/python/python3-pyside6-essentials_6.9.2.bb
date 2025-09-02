SUMMARY = "Python bindings for the Qt cross-platform application and UI framework (Essentials)"
HOMEPAGE = "https://pyside.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1).replace('-', '_', 1)}"

#https://files.pythonhosted.org/packages/9a/a1/1203d4db6919b42a937d9ac5ddb84b20ea42eb119f7c1ddeb77cb8fdb00c/pyside6_essentials-6.9.2-cp39-abi3-manylinux_2_39_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/9a/a1/1203d4db6919b42a937d9ac5ddb84b20ea42eb119f7c1ddeb77cb8fdb00c/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "d0f701503974bd51b408966539aa6956f3d8536e547ea8002fbfb3d77796bbc3"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "already-stripped file-rdeps"

