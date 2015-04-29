SRC_URI = "\
	gitsm://github.com/rust-lang/rust.git;protocol=https \
	https://static.rust-lang.org/stage0-snapshots/rust-stage0-2015-03-27-5520801-linux-x86_64-ef2154372e97a3cb687897d027fd51c8f2c5f349.tar.bz2;unpack=0 \
"

SRC_URI[md5sum] = "6447489e0009519c845b8e350c220636"
SRC_URI[sha256sum] = "b62eed6bdb3cb356c90d587e9d9ee7fb5aedad917ff872c04e67e20b4c8f1c91"

S = "${WORKDIR}/git"
PV .= "+git${SRCPV}"
require rust.inc

