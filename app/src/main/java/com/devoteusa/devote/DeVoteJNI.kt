package com.devoteusa.devote

import java.nio.ByteBuffer

object DeVoteJNI {
    external fun generateVoterKeypair(pk_out: ByteArray, sk_out: ByteArray): Unit

    external fun generateVote(tree_depth: Int, eid_bits: Int, voter_idx: Int, vote: Int,
                              merkle_tree_buffer: ByteArray, rt_buffer: ByteArray, eid_buffer: ByteArray,
                              sk_buffer: ByteArray, pk_eid_buffer: ByteArray,
                              r1cs_proving_key_buffer: ByteArray,
                              r1cs_verification_key_buffer: ByteArray, proof_buffer_out: ByteArray,
                              pinput_buffer_out: ByteArray, ct_buffer_out: ByteArray,
                              sn_buffer_out: ByteArray): Unit

    init {
        System.loadLibrary("devote")
    }
}