SUMMARY = "The Imaging Source SDK for GenTL based camera interactions."
HOMEPAGE = "https://www.theimagingsource.com/en-us/"
LICENSE = "CLOSED"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

##https://files.pythonhosted.org/packages/e5/b8/aaa5b67ec696b3768a82d8d3bbd160ff07b362ee0d6093115d19c2f6f469/imagingcontrol4pyside6-6.9.0.102-py311-none-manylinux_2_39_aarch64.whl
#SRC_URI = "https://files.pythonhosted.org/packages/e5/b8/aaa5b67ec696b3768a82d8d3bbd160ff07b362ee0d6093115d19c2f6f469/${WHL_PN}-${PV}-py311-none-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-py311-none-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
#SRC_URI[sha256sum] = "fc5ed425faa62689473defed2189ac45728b335956205327c5418408c4c5982e"

SRC_URI = "file://imagingcontrol4pyside6-6.7.0.102-py39-none-manylinux_2_31_aarch64.whl;subdir=dist"

S = "${WORKDIR}"

do_compile[noexec] = "1"
INSANE_SKIP:${PN} += "file-rdeps"

RDEPENDS:${PN} = "\
    python3-imagingcontrol4 \
    python3-pyside6 \
    python3-shiboken6 \
    python3-pyside6-addons \
    python3-pyside6-essentials \
"

#inherit python3-dir
#do_install[depends] += "unzip-native:do_populate_sysroot"
#do_install() {
#    install -d ${D}${PYTHON_SITEPACKAGES_DIR}
#    rm -rf ${WORKDIR}/wheel && mkdir -p ${WORKDIR}/wheel
#    unzip -q ${WORKDIR}/imagingcontrol4pyside6-*.whl -d ${WORKDIR}/wheel
#
#    if [ -d "${WORKDIR}/wheel/imagingcontrol4pyside6-"*".data/purelib" ]; then
#        cp -a ${WORKDIR}/wheel/imagingcontrol4pyside6-*.data/purelib/* ${D}${PYTHON_SITEPACKAGES_DIR}/
#    fi
#    if [ -d "${WORKDIR}/wheel/imagingcontrol4pyside6-"*".data/platlib" ]; then
#        cp -a ${WORKDIR}/wheel/imagingcontrol4pyside6-*.data/platlib/* ${D}${PYTHON_SITEPACKAGES_DIR}/
#    fi
#
#    [ -d "${WORKDIR}/wheel/imagingcontrol4pyside6" ] && \
#        cp -a ${WORKDIR}/wheel/imagingcontrol4pyside6 ${D}${PYTHON_SITEPACKAGES_DIR}/
#        [ -d "${WORKDIR}/wheel/imagingcontrol4pyside6-"*".dist-info" ] && \
#        cp -a ${WORKDIR}/wheel/imagingcontrol4pyside6-*.dist-info ${D}${PYTHON_SITEPACKAGES_DIR}/
#}
#
#INSANE_SKIP:${PN} += "file-rdeps"
#
#FILES:${PN} += " \
#    ${PYTHON_SITEPACKAGES_DIR}/imagingcontrol4pyside6 \
#    ${PYTHON_SITEPACKAGES_DIR}/imagingcontrol4pyside6-*.dist-info \
#"
