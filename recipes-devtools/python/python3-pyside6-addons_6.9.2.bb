SUMMARY = "Python bindings for the Qt cross-platform application and UI framework (Addons)"
HOMEPAGE = "https://pyside.org/"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1).replace('-', '_', 1)}"

#https://files.pythonhosted.org/packages/f4/55/dc42a73387379bae82f921b7659cd2006ec0e80f7052f83ddc07e9eb9cca/pyside6_addons-6.9.2-cp39-abi3-manylinux_2_39_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/f4/55/dc42a73387379bae82f921b7659cd2006ec0e80f7052f83ddc07e9eb9cca/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-cp39-abi3-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "af8dee517de8d336735a6543f7dd496eb580e852c14b4d2304b890e2a29de499"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "already-stripped file-rdeps"

