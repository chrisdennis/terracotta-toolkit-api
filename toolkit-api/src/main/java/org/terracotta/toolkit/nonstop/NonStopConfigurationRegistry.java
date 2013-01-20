/*
 * All content copyright Terracotta, Inc., unless otherwise indicated. All rights reserved.
 */
package org.terracotta.toolkit.nonstop;

import org.terracotta.toolkit.ToolkitObjectType;
import org.terracotta.toolkit.builder.NonStopConfigurationBuilder;
import org.terracotta.toolkit.object.ToolkitObject;

/**
 * This class could be used for registering {@link NonStopConfiguration}.<br>
 * Users are recommended to use {@link NonStopConfigurationBuilder} instead of directly using this class.<br>
 * <br>
 * A user is allowed to register {@link NonStopConfiguration} for a {@link ToolkitObjectType}, an instance, a particular
 * method in the ToolkitObject & a particular method for a particular instance.<br>
 * <br>
 * If multiple configurations could match for a particular operation, then the order in which the
 * {@link NonStopConfiguration} is determined as follows:
 * <ul>
 * <li>NonStopConfiguration for Current Thread</li>
 * <li>NonStopConfiguration for the method and the {@link ToolkitObject} instance</li>
 * <li>NonStopConfiguration for the {@link ToolkitObject} instance</li>
 * <li>NonStopConfiguration for the method and {@link ToolkitObjectType}</li>
 * <li>NonStopConfiguration for {@link ToolkitObjectType}</li>
 * </ul>
 */
public interface NonStopConfigurationRegistry {
  /**
   * Register {@link NonStopConfiguration} for the all {@link ToolkitObjectType} passed in.
   */
  void registerForType(NonStopConfiguration config, ToolkitObjectType... types);

  /**
   * Register {@link NonStopConfiguration} for all the {@link ToolkitObjectType} which have the name passed in as the
   * parameter.
   */
  void registerForInstance(NonStopConfiguration config, String toolkitTypeName, ToolkitObjectType type);

  /**
   * Register {@link NonStopConfiguration} for the method in {@link ToolkitObject}
   */
  void registerForTypeMethod(NonStopConfiguration config, String methodName, ToolkitObjectType type);

  /**
   * Register {@link NonStopConfiguration} for the method in {@link ToolkitObjectType} and the instance name.
   */
  void registerForInstanceMethod(NonStopConfiguration config, String methodName, String toolkitTypeName,
                                 ToolkitObjectType type);

  /**
   * Register a different timeout for search operations.<br>
   * Please note that the rest of the {@link NonStopConfiguration} is used which was registered for
   * {@link ToolkitObject} instance.
   * 
   * @throws IllegalArgumentException if timeout <= 0
   */
  void registerTimeoutForSearch(long timeout, String instanceName, ToolkitObjectType objectType);

  /**
   * @return {@link NonStopConfiguration} for the {@link ToolkitObjectType}
   */
  NonStopConfiguration getConfigForType(ToolkitObjectType type);

  /**
   * @return {@link NonStopConfiguration} for the {@link ToolkitObjectType} and whose name is passed in as param.
   */
  NonStopConfiguration getConfigForInstance(String toolkitTypeName, ToolkitObjectType type);

  /**
   * @return {@link NonStopConfiguration} for the {@link ToolkitObjectType} and whose method name is passed in as param.
   */
  NonStopConfiguration getConfigForTypeMethod(String methodName, ToolkitObjectType type);

  /**
   * @return {@link NonStopConfiguration} for the {@link ToolkitObjectType} and whose instance name & method name is
   *         passed in as param.
   */
  NonStopConfiguration getConfigForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);

  /**
   * @return the timeout registered for search operations.<br>
   *         If the timeout was not registered, the searchTimeout setting from the nonstop configuration will be
   *         returned. If the searchTimeout was not specified in the nonstop configuration, the default search timeout
   *         will be returned.
   *
   */
  long getTimeoutForSearch(String instanceName, ToolkitObjectType objectType);

  /**
   * De-register the {@link NonStopConfiguration} associated with the {@link ToolkitObjectType}
   */
  NonStopConfiguration deregisterForType(ToolkitObjectType type);

  /**
   * De-register the {@link NonStopConfiguration} associated with the {@link ToolkitObjectType} and whose instance name
   * is passed in as param.
   */
  NonStopConfiguration deregisterForInstance(String toolkitTypeName, ToolkitObjectType type);

  /**
   * De-register the {@link NonStopConfiguration} associated with the {@link ToolkitObjectType} and whose method name is
   * passed in as param.
   */
  NonStopConfiguration deregisterForTypeMethod(String methodName, ToolkitObjectType type);

  /**
   * De-register the {@link NonStopConfiguration} associated with the {@link ToolkitObjectType} and whose method name &
   * instance name is passed in as param.
   */
  NonStopConfiguration deregisterForInstanceMethod(String methodName, String toolkitTypeName, ToolkitObjectType type);

  /**
   * De-register the timeout set for search.
   */
  long deregisterTimeoutForSearch(String instanceName, ToolkitObjectType objectType);
}
