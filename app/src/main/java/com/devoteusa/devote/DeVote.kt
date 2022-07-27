package com.devoteusa.devote


object DeVote {

    data class VoterKeyPair(val pk: ByteArray, val sk: ByteArray)
    data class VoteData(val proof: ByteArray, val pinput: ByteArray,
                        val ct: ByteArray, val sn: ByteArray)

    fun generateVoterKeypair(): VoterKeyPair{
        val pk = ByteArray(32);
        val sk = ByteArray(32);
        DeVoteJNI.generateVoterKeypair(pk, sk);
        return VoterKeyPair(pk,sk);
    }

    fun generateVote(tree_depth: Int, voter_idx: Int, vote: Int,
                     merkle_tree_buffer: ByteArray, rt_buffer: ByteArray, eid_buffer: ByteArray,
                     sk_buffer: ByteArray, pk_eid_buffer: ByteArray,
                     r1cs_proving_key_buffer: ByteArray,
                     r1cs_verification_key_buffer: ByteArray): VoteData {
        val proof_buffer_out = ByteArray(192)
        val pinput_buffer_out = ByteArray(164)
        val ct_buffer_out = ByteArray(1300)
        val sn_buffer_out = ByteArray(68)

        DeVoteJNI.generateVote(tree_depth, 64, voter_idx, vote,
            merkle_tree_buffer, rt_buffer, eid_buffer,
            sk_buffer, pk_eid_buffer, r1cs_proving_key_buffer,
            r1cs_verification_key_buffer, proof_buffer_out, pinput_buffer_out,
            ct_buffer_out, sn_buffer_out)

        return VoteData(proof_buffer_out, pinput_buffer_out,ct_buffer_out, sn_buffer_out)
    }

}