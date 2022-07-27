package com.devoteusa.devote

import java.nio.ByteBuffer

object DeVoteJNI {
    external fun generateVoterKeypair(pk_out: ByteArray, sk_out: ByteArray)

    external fun generateVote(tree_depth: Int, eid_bits: Int, voter_idx: Int, vote: Int,
                              merkle_tree_buffer: ByteArray, rt_buffer: ByteArray, eid_buffer: ByteArray,
                              sk_buffer: ByteArray, pk_eid_buffer: ByteArray,
                              r1cs_proving_key_buffer: ByteArray,
                              r1cs_verification_key_buffer: ByteArray, proof_buffer_out: ByteArray,
                              pinput_buffer_out: ByteArray, ct_buffer_out: ByteArray,
                              sn_buffer_out: ByteArray)

    external fun verifyTally(tree_depth : Int,
                            cts_buffer_array: Array<ByteArray>,
                            vk_eid_buffer: ByteArray,
                            pk_crs_buffer: ByteArray,
                            vk_crs_buffer: ByteArray,
                            dec_proof_buffer: ByteArray,
                            voting_res_buffer: ByteArray): Boolean

    init {
        System.loadLibrary("devote")
    }
}