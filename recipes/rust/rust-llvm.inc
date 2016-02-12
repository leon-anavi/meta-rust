require rust-shared-source.inc

SUMMARY = "LLVM compiler framework (packaged with rust)"
LICENSE = "NCSA"

S .= "/src/llvm"

inherit autotools

EXTRA_OECONF += "--enable-targets=x86,x86_64,arm,aarch64,mips,powerpc"
EXTRA_OECONF += "--enable-optimized"
EXTRA_OECONF += "--disable-assertions"
EXTRA_OECONF += "--disable-docs"
EXTRA_OECONF += "--enable-bindings=none"
EXTRA_OECONF += "--disable-terminfo"
EXTRA_OECONF += "--disable-zlib"
EXTRA_OECONF += "--disable-libffi"

EXTRA_OECONF += "--enable-keep-symbols"

do_install_append () {
	cd ${D}${bindir}
	ln -s *-llc llc
	for i in *-llvm-*; do
		link=$(echo $i | sed -e 's/.*-llvm-\(.*\)/\1/')
		ln -s $i llvm-$link
	done
}

BBCLASSEXTEND = "native"

# avoid error: debugedit failed with exit code 256
INHIBIT_PACKAGE_DEBUG_SPLIT="1"

# ship rust-llvm files and directories
FILES_${PN} += "/usr/share/*"
FILES_${PN} += "/usr/lib/*"
