SUMMARY = "The Imaging Source SDK for GenTL based camera interactions."
HOMEPAGE = "https://www.theimagingsource.com/en-us/"
# Recipe created by recipetool
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

#https://files.pythonhosted.org/packages/07/69/5a43995037b378257ce397fcdd068a14b3c380c42b305b4ee0c306aece6d/imagingcontrol4-1.3.0.3125-py38-none-manylinux_2_27_aarch64.whl
#SRC_URI = "https://files.pythonhosted.org/packages/07/69/5a43995037b378257ce397fcdd068a14b3c380c42b305b4ee0c306aece6d/${WHL_PN}-${PV}-py38-none-manylinux_2_27_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-py38-none-manylinux_2_27_${TARGET_ARCH}.whl;subdir=dist"
#SRC_URI[sha256sum] = "164de0eb38ddb05033b562e63a35fc6adbb380c4d28ce3aec37304de82fd3880"

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"
SRC_URI = "file://${WHL_PN}-${PV}-py38-none-manylinux_2_27_${TARGET_ARCH}.whl;subdir=dist"

inherit python3-dir setuptools3
#inherit python3-dir
#do_install[depends] += "unzip-native:do_populate_sysroot"
#do_install() {
#    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
#    rm -rf ${WORKDIR}/wheel && mkdir -p ${WORKDIR}/wheel
#    unzip -q ${WORKDIR}/imagingcontrol4-*.whl -d ${WORKDIR}/wheel
#
#    if [ -d "${WORKDIR}/wheel/imagingcontrol4-"*".data/purelib" ]; then
#        cp --preserve=mode,timestamps -R ${WORKDIR}/wheel/imagingcontrol4-*.data/purelib/* ${D}${PYTHON_SITEPACKAGES_DIR}/
#    fi
#    if [ -d "${WORKDIR}/wheel/imagingcontrol4-"*".data/platlib" ]; then
#        cp --preserve=mode,timestamps -R ${WORKDIR}/wheel/imagingcontrol4-*.data/platlib/* ${D}${PYTHON_SITEPACKAGES_DIR}/
#    fi
#
#    [ -d "${WORKDIR}/wheel/imagingcontrol4" ] && \
#        cp --preserve=mode,timestamps -R ${WORKDIR}/wheel/imagingcontrol4 ${D}${PYTHON_SITEPACKAGES_DIR}/
#    [ -d "${WORKDIR}/wheel/imagingcontrol4-"*".dist-info" ] && \
#        cp --preserve=mode,timestamps -R ${WORKDIR}/wheel/imagingcontrol4-*.dist-info ${D}${PYTHON_SITEPACKAGES_DIR}/
#}

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "file-rdeps"

RDEPENDS:${PN} = "\
    python3-numpy \
    python3-pyside6 \
"

#FILES:${PN} += " \
#    ${PYTHON_SITEPACKAGES_DIR}/imagingcontrol4 \
#    ${PYTHON_SITEPACKAGES_DIR}/imagingcontrol4-*.dist-info \
#"
