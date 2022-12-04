/*
 * Copyright 2022 281165273grape@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package io.sui.clients;


import io.sui.models.transactions.RPCTransactionRequestParams;
import io.sui.models.transactions.TransactionBytes;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The interface Transaction builder.
 *
 * @author grapebaba
 * @since 2022.11
 */
public interface TransactionBuilder {

  /**
   * Split coin completable future.
   *
   * @param signer the signer
   * @param coin the coin object id
   * @param splitAmounts the split amounts
   * @param gas the gas
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> splitCoin(
      String signer, String coin, List<Long> splitAmounts, String gas, long gasBudget);

  /**
   * Split coin equal completable future.
   *
   * @param signer the signer
   * @param coin the coin object id
   * @param splitCount the split count
   * @param gas the gas
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> splitCoinEqual(
      String signer, String coin, long splitCount, String gas, long gasBudget);

  /**
   * Merge coins completable future.
   *
   * @param signer the signer
   * @param primaryCoin the primary coin
   * @param toMergeCoin the to merge coin
   * @param gas the gas
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> mergeCoins(
      String signer, String primaryCoin, String toMergeCoin, String gas, long gasBudget);

  /**
   * Pay completable future.
   *
   * @param signer the signer
   * @param inputCoins the input coins
   * @param recipients the recipients
   * @param amounts the amounts
   * @param gas the gas
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> pay(
      String signer,
      List<String> inputCoins,
      List<String> recipients,
      List<Long> amounts,
      String gas,
      long gasBudget);

  /**
   * Pay sui completable future.
   *
   * @param signer the signer
   * @param inputCoins the input coins
   * @param recipients the recipients
   * @param amounts the amounts
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> paySui(
      String signer,
      List<String> inputCoins,
      List<String> recipients,
      List<Long> amounts,
      long gasBudget);

  /**
   * Pay all sui completable future.
   *
   * @param signer the signer
   * @param inputCoins the input coins
   * @param recipient the recipient
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> payAllSui(
      String signer, List<String> inputCoins, String recipient, long gasBudget);

  /**
   * Transfer sui completable future.
   *
   * @param signer the signer
   * @param coin the coin
   * @param gasBudget the gas budget
   * @param recipient the recipient
   * @param amount the amount
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> transferSui(
      String signer, String coin, long gasBudget, String recipient, long amount);

  /**
   * Transfer object completable future.
   *
   * @param signer the signer
   * @param suiObject the sui object
   * @param gas the gas
   * @param gasBudget the gas budget
   * @param recipient the recipient
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> transferObject(
      String signer, String suiObject, String gas, long gasBudget, String recipient);

  /**
   * Batch transaction completable future.
   *
   * @param signer the signer
   * @param batchTransactionParams the batch transaction params
   * @param gas the gas
   * @param gasBudget the gas budget
   * @return the completable future
   */
  CompletableFuture<TransactionBytes> batchTransaction(
      String signer,
      List<RPCTransactionRequestParams> batchTransactionParams,
      String gas,
      long gasBudget);
}