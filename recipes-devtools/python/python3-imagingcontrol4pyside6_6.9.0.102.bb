SUMMARY = "The Imaging Source SDK for GenTL based camera interactions."
HOMEPAGE = "https://www.theimagingsource.com/en-us/"
LICENSE = "CLOSED"

inherit python3-dir setuptools3

WHL_PN="${@ d.getVar('PN').replace(d.getVar('PYTHON_PN')+'-', '', 1)}"

#https://files.pythonhosted.org/packages/e5/b8/aaa5b67ec696b3768a82d8d3bbd160ff07b362ee0d6093115d19c2f6f469/imagingcontrol4pyside6-6.9.0.102-py311-none-manylinux_2_39_aarch64.whl
SRC_URI = "https://files.pythonhosted.org/packages/e5/b8/aaa5b67ec696b3768a82d8d3bbd160ff07b362ee0d6093115d19c2f6f469/${WHL_PN}-${PV}-py311-none-manylinux_2_39_${TARGET_ARCH}.whl;downloadfilename=${WORKDIR}/dist/${WHL_PN}-${PV}-py311-none-manylinux_2_39_${TARGET_ARCH}.whl;subdir=dist"
SRC_URI[sha256sum] = "fc5ed425faa62689473defed2189ac45728b335956205327c5418408c4c5982e"

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

#do_pyproject_conf() {
#    echo "[project]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "name = \"imagingcontrol4\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "version = \"1.3.0.3125\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "summary = \"IC Imaging Control 4 Core Library\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "requires-python = \">= 3.8\"" >> ${WORKDIR}/dist/pyproject.toml
#    echo "dependencies = [\"numpy\", \"pyside6\"]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "" >> ${WORKDIR}/dist/pyproject.toml
#    echo "[tool.setuptools.packages.find]" >> ${WORKDIR}/dist/pyproject.toml
#    echo "where = [\"./\"]" >> ${WORKDIR}/dist/pyproject.toml
#}
#addtask pyproject_conf before do_configure after do_patch

